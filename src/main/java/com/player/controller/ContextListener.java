package com.player.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by root_pc on 1/14/2017.
 */

@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ContextListener() {}

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
