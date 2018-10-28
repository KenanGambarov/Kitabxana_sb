package com.kitabxana_sb.controller;

import com.kitabxana_sb.dao.Main_Dao;
import com.kitabxana_sb.impl.Main;
import com.kitabxana_sb.service.Registr_service;
import com.kitabxana_sb.tables.Book;
import com.kitabxana_sb.tables.User_info;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    Registr_service service;
    @Autowired
    Main_Dao md;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET})
    public ModelAndView main2(@RequestParam(value = "error", required = false) String error) {
        ModelAndView map = new ModelAndView();
        if (error != null) {
            map.addObject("error", "The email address or password you entered is not valid!");
        }
        map.setViewName("login");
        return map;
    }

    private void printUserDetails() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        logger.info("password = " + userDetails.getPassword());
        logger.info("username = " + userDetails.getUsername());

        System.out.println("password + username = " + userDetails.getPassword() + " " + userDetails.getUsername());

        userDetails.getAuthorities().forEach((auth) -> {
            logger.info(auth.getAuthority());

        });
    }

    @RequestMapping(value = {"/registration"}, method = {RequestMethod.GET}, produces = {"text/plain;charset=UTF-8"})
    public String Register(User_info user, ModelMap map) {
        map.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = {RequestMethod.POST}, produces = {"text/plain;charset=UTF-8"})
    public String Registr(@Validated @ModelAttribute("user") User_info user, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            return "registration";
        }
        this.service.insertUser(user);
        return "redirect:login";
    }

    @RequestMapping(value = {"/main"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView main(@ModelAttribute("main") Main main, ModelAndView model, HttpServletRequest request) {
//        printUserDetails();
        List<Book> list1 = this.md.getbookList(request);
        List<Book> list2 = this.md.getbookByAuthor();
        List<Book> list3 = this.md.getbookByTitle();
        model.addObject("book_list", list1);
        model.addObject("author_list", list2);
        model.addObject("title_list", list3);
        model.setViewName("main");
        return model;
    }

    @RequestMapping(value = {"/downloadPDF"}, method = {RequestMethod.GET})
    public ModelAndView downloadPDF(HttpServletRequest request, Model model) {
        List<Book> list1 = this.md.getbookList(request);
        return new ModelAndView("pdfView", "book_list", list1);
    }
}
