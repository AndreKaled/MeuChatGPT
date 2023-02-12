package chatgpt;

import java.util.List;
import java.util.Scanner;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;

public class ChatIA {

	private static final String API_KEY = "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";
	OpenAiService service = new OpenAiService(API_KEY);
	CompletionRequest request;
	Scanner s = new Scanner(System.in);
	public String resposta;

	public void solicitar(String solicitacao) {
		request = CompletionRequest.builder().model("text-davinci-003").prompt(solicitacao).maxTokens(4000).build();
	}

	public void responder() {
		List<CompletionChoice> respostas = service.createCompletion(request).getChoices();
		resposta = respostas.get(0).getText();
	}

}
