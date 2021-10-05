package com.example.ClinicaOdontologica;

import com.example.ClinicaOdontologica.model.DTO.OdontologoDTO;
import com.example.ClinicaOdontologica.model.DTO.PacienteDTO;
import com.example.ClinicaOdontologica.model.DTO.TurnoDTO;
import com.example.ClinicaOdontologica.model.Direccion;
import com.example.ClinicaOdontologica.model.Odontologo;
import com.example.ClinicaOdontologica.model.Paciente;
import com.example.ClinicaOdontologica.model.Turno;
import com.example.ClinicaOdontologica.service.OdontologoService;
import com.example.ClinicaOdontologica.service.PacienteService;
import com.example.ClinicaOdontologica.service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnosTests {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(roles = "ADMIN")
    public void cargarDataSet() throws Exception {
        Direccion domicilio = new Direccion("San Martin", 569, "Corrientes", "Corrientes");
        Paciente paciente = new Paciente("Colombo", "Romina",38313392 , "romi@mail.com","2020/03/09");
        paciente.setDireccion(domicilio);
        pacienteService.crearPaciente(objectMapper.convertValue(paciente, PacienteDTO.class));
        Odontologo odontologo = new Odontologo("Novak", "Bruno", 123);
        this.odontologoService.crearOdontologo(objectMapper.convertValue(odontologo, OdontologoDTO.class));


        Paciente turnoPaciente = objectMapper.convertValue(pacienteService.buscarPaciente(1L), Paciente.class);
        Odontologo turnoOdontologo = objectMapper.convertValue(odontologoService.buscarOdontologo(1L), Odontologo.class);
        Turno turno = new Turno("2020/10/15", turnoOdontologo, turnoPaciente);
        String nuevoTurno = turnoService.crearTurno(objectMapper.convertValue(turno, TurnoDTO.class));

        Assert.assertEquals(nuevoTurno, "Se generó un turno");
    }


    @Test
    @WithMockUser(roles="ADMIN")
    public void listarTurnos() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/listarTurnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}