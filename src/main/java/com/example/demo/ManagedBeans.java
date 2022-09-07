package com.example.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


    @ManagedBean(name = "managedBeans")
    @SessionScoped
    public class ManagedBeans implements Serializable {
        String name;
        String surname;
        String email;
        String phone;
        String company;
        String company_name;
        String invoice_address;
        String city;
        int tax_id;
        String tax_office;
        String vax_exemption;
        int number_of_attendees;
        String attendees_information;
        String ticket_categories;
        String payment_method;
        String notes;

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getTicket_categories() {
            return ticket_categories;
        }

        public void setTicket_categories(String ticket_categories) {
            this.ticket_categories = ticket_categories;
        }

        public int getNumber_of_attendees() {
            return number_of_attendees;
        }

        public void setNumber_of_attendees(int number_of_attendees) {
            this.number_of_attendees = number_of_attendees;
        }

        public String getAttendees_information() {
            return attendees_information;
        }

        public void setAttendees_information(String attendees_information) {
            this.attendees_information = attendees_information;
        }

        public String getVax_exemption() {
            return vax_exemption;
        }

        public void setVax_exemption(String vax_exemption) {
            this.vax_exemption = vax_exemption;
        }

        public int getTax_id() {
            return tax_id;
        }

        public void setTax_id(int tax_id) {
            this.tax_id = tax_id;
        }

        public String getTax_office() {
            return tax_office;
        }

        public void setTax_office(String tax_office) {
            this.tax_office = tax_office;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getInvoice_address() {
            return invoice_address;
        }

        public void setInvoice_address(String invoice_address) {
            this.invoice_address = invoice_address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public void saveDatasToDatabase() throws SQLException {
            int i=0;
            Connection connection=null;
            PreparedStatement preparedStatement=null;
            try {
                Class.forName("org.postgresql.Driver");
                connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres2","postgres","0000");
                preparedStatement=connection.prepareStatement("INSERT INTO dbtablo (name,surname,email,phone,company,company_name,invoice_address,city,tax_id,tax_office,vax_exemption,number_of_attendees,attendees_information,ticket_categories,payment_method,notes) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,surname);
                preparedStatement.setString(3,email);
                preparedStatement.setString(4,phone);
                preparedStatement.setString(5,company);
                preparedStatement.setString(6,company_name);
                preparedStatement.setString(7,invoice_address);
                preparedStatement.setString(8,city);
                preparedStatement.setInt(9,tax_id);
                preparedStatement.setString(10,tax_office);
                preparedStatement.setString(11,vax_exemption);
                preparedStatement.setInt(12,number_of_attendees);
                preparedStatement.setString(13,attendees_information);
                preparedStatement.setString(14,ticket_categories);
                preparedStatement.setString(15,payment_method);
                preparedStatement.setString(16,notes);
                i=preparedStatement.executeUpdate();
            }
            catch (Exception e){
                System.out.println("error"+e);
            }
            finally {
                if (connection!=null){
                    connection.close();
                }
                if(preparedStatement!=null){
                    preparedStatement.close();;
                }
            }
            if(i>0){
                System.out.println("Kayıt oldu.");
            }
            else {
                System.out.println("Kayıt başarısız.");
            }
        }
    }


