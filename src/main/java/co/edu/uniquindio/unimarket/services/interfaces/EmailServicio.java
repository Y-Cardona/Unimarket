package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.EmailDTO;

public interface EmailServicio {

    void enviarEmail(EmailDTO emailDTO) throws Exception;

}
