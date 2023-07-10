package com.example.vueproxy;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@CrossOrigin
@Controller
public class SimpleSSEController {
    /**
     * 服务器流式推送
     */
    @RequestMapping(value = "/sse")
    @ResponseBody
    public String getStreamDataImprove(HttpServletResponse response) {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        String s = "";
        while (true) {
            s = "data: " +Thread.currentThread().getName() +  new Date() + "\n\n"; // 按照data: msg \n\n
            try {
                PrintWriter pw = response.getWriter();
                Thread.sleep(1000L);
                pw.write(s);
                pw.flush();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/sse-stream")
    @ResponseBody
    public void getStreamDataImprove0(HttpServletResponse response) {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        String s = "data: " + new Date() + "\n\n";
        try {
            PrintWriter pw = response.getWriter();
            pw.write(s);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 服务器重连推送
     */
    @RequestMapping(value = "/sse-retry")
    @ResponseBody
    public void getStreamDataImprove1(HttpServletResponse response) {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        String s = "retry: 2000\n";
        s += "data: " + new Date() + "\n\n";
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(s);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }











}
