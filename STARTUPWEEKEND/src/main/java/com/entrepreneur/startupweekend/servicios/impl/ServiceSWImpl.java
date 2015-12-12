package com.entrepreneur.startupweekend.servicios.impl;

import com.entrepreneur.startupweekend.dao.IGenericDao;
import com.entrepreneur.startupweekend.modelo.Posicion;
import com.entrepreneur.startupweekend.modelo.Usuario;
import com.entrepreneur.startupweekend.modelo.Zona;
import com.entrepreneur.startupweekend.modelo.ZonaPunto;
import com.entrepreneur.startupweekend.servicios.ServiceSW;
import static java.lang.StrictMath.log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class ServiceSWImpl implements ServiceSW {
       

    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private VelocityEngine velocityEngine;
    @Autowired
    IGenericDao dao;
    
    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    @Override
    public Usuario persistUsuario(Usuario usuario) throws Exception {
        try {
            usuario.setIdUsuario(null);
            dao.create(usuario);
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Posicion persistPosicion(Posicion posicion) throws Exception {
        try {
            posicion.setIdPosicion(null);
            dao.create(posicion);
            return posicion;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Zona persistZona(Zona zona) throws Exception {
        try {
            zona.setIdZona(null);
            dao.create(zona);
            return zona;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Zona> getZones() throws Exception {
        List<Zona> zonas = dao.findAll(Zona.class);
        return zonas;
    }

    public ZonaPunto persistZonaPunto(ZonaPunto zonaPunto) throws Exception {
        try {
            zonaPunto.setIdZonaPunto(null);
            dao.create(zonaPunto);
            return zonaPunto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<ZonaPunto> getZonaPuntoByZona(Zona zona) throws Exception {
        try {
            List<ZonaPunto> lista = dao.find(""
                    + "select h "
                    + "from ZonaPunto h "
                    + "where h.zona.idZona=" + zona.getIdZona(), ZonaPunto.class);
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void enviarCorreoPrueba(String usuario, String zona) {
        try {
            System.out.println("entro al metodo con "+usuario+" y "+zona);
            Map<String, Object> model = new HashMap<String, Object>();            
            model.put("userNameParam", usuario);
            model.put("variable", "Es otro valor");
            model.put("emailAddress", "mail.testmyoffers@gmail.com");
            model.put("template", "mail_template_html.vm");
//            model.put("template", "email-template.vm");
            String to = "jonathan.valdivia.r@gmail.com";
            String subject = "Testing myOffers app";
            SimpleAppMsgPreparator simpleAppMsgPreparator = new SimpleAppMsgPreparator(to, subject, model);
            this.mailSender.send(simpleAppMsgPreparator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class SimpleAppMsgPreparator implements MimeMessagePreparator {

        private String template;
        private String to;
        private String subject;
        private Map<String, Object> model;
        private boolean useHtml;
        private String body;
        private InputStreamSource attachment;

        public SimpleAppMsgPreparator(String to, String subject, Map<String, Object> model) {
            System.out.println("entra a este constructor::::");
            this.template = (String) model.get("template");
            this.subject = subject;
            this.model = model;
            this.to = to;
            this.useHtml = true;
        }

        public SimpleAppMsgPreparator(String to, String subject, Map<String, Object> model, InputStreamSource adjunto) {
            this.template = (String) model.get("template");
            this.subject = subject;
            this.model = model;
            this.to = to;
            this.useHtml = true;
            this.attachment = adjunto;
        }

        public SimpleAppMsgPreparator(String to, String subject, String body) {
            this.subject = subject;
            this.to = to;
            this.useHtml = true;
            this.body = body;
        }

        @Override
        public void prepare(MimeMessage message) throws Exception {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, useHtml);
//            messageHelper.addAttachment("facturaElectronica.xml", attachment, "application/xml");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, model);            
            this.body = text;
            messageHelper.setText(text, useHtml);
            messageHelper.setText(this.body, useHtml);
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

}
