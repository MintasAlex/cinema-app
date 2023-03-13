package com.training.cinemaapp.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
class RestResponseStatusExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object object,
            Exception exception) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject("exception", exception.getMessage());
        return model;
    }

}
