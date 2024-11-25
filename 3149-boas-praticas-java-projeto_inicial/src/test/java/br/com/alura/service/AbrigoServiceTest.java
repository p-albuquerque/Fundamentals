package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    private ClientHttpConfiguration _client = mock(ClientHttpConfiguration.class);
    private AbrigoService _abrigoService = new AbrigoService(_client);
    private HttpResponse<String> _response = mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("Test", "888888", "test@email.com");

    @BeforeEach
    public void setUp() throws Exception {
        when(_client.dispararRequisicaoGet(anyString())).thenReturn(_response);
    }

    @Test
    public void listarAbrigoTest() throws Exception {
        abrigo.setId(0L);

        // Quando existe abrigo
        _listarAbrigosTest("[{" + abrigo.toString() + "}]", "Abrigos cadastrados:", "0 - Test");

        // Quando nao existe abrigo
        _listarAbrigosTest("[]", "Nao ha abrigos cadastrados");
    }

    private void _listarAbrigosTest(String responseBody, String ...expectedMessages) throws IOException, InterruptedException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(_response.body()).thenReturn(responseBody);

        _abrigoService.listarAbrigo();

        String[] actualMessages = baos.toString().split(System.lineSeparator());
        for (int i = 0; i < expectedMessages.length; i++) {
            Assertions.assertEquals(expectedMessages[i], actualMessages[i]);

        }
    }
}
