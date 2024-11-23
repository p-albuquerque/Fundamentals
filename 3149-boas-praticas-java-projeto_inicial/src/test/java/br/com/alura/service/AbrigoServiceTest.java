package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
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

    @Test
    public void listarAbrigoTest() throws Exception {
        abrigo.setId(0L);

        String expectedAbrigosCadastrados = "Abrigos cadastrados:";
        String expectedAbrigoInfo = "0 - Test";

        // Ler conteudo logado atraves do "System.out.println"
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // mockar retorno requisicao get do _client e o conteudo json da resposta
        when(_client.dispararRequisicaoGet(anyString())).thenReturn(_response);
        when(_response.body()).thenReturn("[{" + abrigo.toString() + "}]"); // o toString precisa retornar a string do objeto no padrao JSONObject

        // Executar metodo alvo do teste
        _abrigoService.listarAbrigo();

        // Obter conteudo logado pelo metodo
        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualAbrigoInfo = lines[1];

        // Assertar respostas com resultado esperado
        Assertions.assertEquals(expectedAbrigosCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedAbrigoInfo, actualAbrigoInfo);
    }
}
