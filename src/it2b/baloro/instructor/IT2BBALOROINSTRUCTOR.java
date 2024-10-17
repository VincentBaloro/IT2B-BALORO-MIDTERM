
package it2b.baloro.instructor;

import java.util.Scanner;

public class IT2BBALOROINSTRUCTOR {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
      String response;
    do{
          System.out.println("1. ADD");
          System.out.println("2. VIEW");
          System.out.println("3. UPDATE");
          System.out.println("4. DELETE");
          System.out.println("5. EXIT");
          
          System.out.println("Enter Action: ");
          int action = sc.nextInt();
          IT2BBALOROINSTRUCTOR instructor = new IT2BBALOROINSTRUCTOR();
          switch(action){
              case 1:
                  instructor.addInstructor();
              break;
              case 2:
                  instructor.viewInstructor();
              break;
              case 3:
                  instructor.viewInstructor();
                  instructor.updateInstructor();
                  instructor.viewInstructor();
              break;
              case 4:
                  instructor.viewInstructor();
                  instructor.deleteInstructor();
                   instructor.viewInstructor();
              break;
              case 5:
                  System.out.println("Thank you, see you soon!");           
              break;
              
              
          }
          System.out.println("Do you want to continue? (yes/no): ");
          response = sc.next();
      }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank you, see you soon!");
    }
    public void addInstructor(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Name: ");
        String iname = sc.next();
        System.out.print("Email: ");
        String iemail = sc.next();
        System.out.print("Department: ");
        String idepart = sc.next();
        System.out.print("Phone Number: ");
        int iphonenum = sc.nextInt();
        System.out.print("Hire Date: ");
        String ihiredate = sc.next();

        String sql = "INSERT INTO tbl_instructor (i_name, i_email, i_department, i_phonenum, i_hiredate) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, iname, iemail, idepart, iphonenum, ihiredate);


    }
    private void viewInstructor() {
        config conf = new config();
        String instructorQuery = "SELECT * FROM tbl_instructor";
        String[] instructorHeaders = {"Name", "Email", "Department", "Phone Number", "Hire Date"};
        String[] instructorColumns = {"i_name", "i_email", "i_department", "i_phonenum", "i_hiredate"};

        conf.viewRecords(instructorQuery, instructorHeaders, instructorColumns);
    }
    private void  updateInstructor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New Name: ");
        String iname = sc.next();
        System.out.println("New Email: ");
        String iemail = sc.next();
        System.out.println("New Department: ");
        String idepart = sc.next();
        System.out.println("New Phone Number: ");
        int iphonenum = sc.nextInt();
        System.out.println("New Hire Date: ");
        String ihiredate = sc.next();
        
        String qry = "UPDATE tbl_instructor set i_name = ?, i_email = ?, i_department = ?, i_phonenum = ?, i_hiredate = ? WHERE i_id = ?";
        config conf = new config();
        conf.updateRecord(qry, iname, iemail,idepart, iphonenum, ihiredate, id);
        
    }
    private void deleteInstructor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to Delete: ");
        int id = sc.nextInt();
     
        String qry = "DELETE FROM tbl_instructor WHERE i_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
}
    
}

    
    

