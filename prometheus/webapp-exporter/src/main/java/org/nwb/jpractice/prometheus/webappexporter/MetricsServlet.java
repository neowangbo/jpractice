package org.nwb.jpractice.prometheus.webappexporter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/metrics")
public class MetricsServlet extends HttpServlet {

    private  static final String MATRIC_TEMPLATE = "campaign_%s{target=\"%s\",result=\"%s\"}\r\n";

    private static final int MAX_TARGETID = 10000;

    private static final String[] RESULTS = {"SUCCESS","FAILED"};

    private static int campaignId = 1;// Start from 1, no maximum limitation

    private static int targetId = 1;// Start from 1, maximum is MAX_TARGETID

    private static Random r = new Random();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));

        // Num targets has been handled. num is [0,150).
        int num = r.nextInt(150);

        for(int i = 0; i < num; i++){
            /**
             * One campaign maximum has MAX_TARGETID targets, so need to increase campaign id, and reset targetId back to 1
             * */
            if(targetId > MAX_TARGETID){
                campaignId ++;
                targetId = 1;
            }

            bw.write(String.format(MATRIC_TEMPLATE, campaignId, targetId));

            targetId++;
        }

        bw.close();
    }

}
