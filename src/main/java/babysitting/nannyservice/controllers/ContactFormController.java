package babysitting.nannyservice.controllers;

import babysitting.nannyservice.domain.ContactForm;
import babysitting.nannyservice.repositories.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactFormController {

    private final ContactFormRepository contactFormRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public ContactFormController(ContactFormRepository contactFormRepository, JavaMailSender javaMailSender) {
        this.contactFormRepository = contactFormRepository;
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/submitContactForm")
    @ResponseBody
    public ResponseEntity<String> submitContactForm(@RequestBody ContactForm contactForm) {
        // Process the submitted form data here
        System.out.println("Name: " + contactForm.getName());
        System.out.println("Email: " + contactForm.getEmail());
        System.out.println("Message: " + contactForm.getMessage());

//        // Save the form data to the database
//        ContactForm contactFormEntity = new ContactForm();
//        contactFormEntity.setName(contactForm.getName());
//        contactFormEntity.setEmail(contactForm.getEmail());
//        contactFormEntity.setMessage(contactForm.getMessage());
//        contactFormRepository.save(contactFormEntity);

        // Send an email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("childcareservice.nanny@gmail.com"); // Replace with the email address you want to send the message to
        mailMessage.setSubject("New Contact Form Submission");
        mailMessage.setText("Name: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\nMessage: " + contactForm.getMessage());
        javaMailSender.send(mailMessage);

        return new ResponseEntity<>("Form submitted successfully.", HttpStatus.OK);
    }
}
