/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge1;

/**
 *
 * @author Cip
 */
// =============================== CLASS MAIN ===================================================================
public class Challenge8 {

    public static void main(String[] args) {
        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
        tutor.setStudent(student);

        // ===============================
        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        // ===============================
        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        // ===============================
        tutorThread.start();
        studentThread.start();
    }
}

// =============================== CLASS TUTOR ===================================================================
class Tutor {

    private Student student;

    // ===============================
    public void setStudent(Student student) {
        this.student = student;
    }

    // ===============================
    public void studyTime() {

        synchronized (this) {

            System.out.println("Tutor has arrived");

            synchronized (student) {

                try {
                    // wait for student to arrive and hand in assignment
                    
                    // release the tutor lock until it gets notify() by someone
                    this.wait();
                } catch (InterruptedException e) {

                }

                student.startStudy();

                System.out.println("Tutor is studying with student");
            }
        }
    }

    // ===============================
    public synchronized void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

// =============================== CLASS STUDENT ===================================================================
class Student {

    private Tutor tutor;

    Student(Tutor tutor) {
        this.tutor = tutor;
    }

    // ===============================
    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    // ===============================
    public void handInAssignment() {

        synchronized (tutor) {

            tutor.getProgressReport();

            synchronized (this) {

                System.out.println("Student handed in assignment");
                tutor.notifyAll();
            }
        }
    }
}
