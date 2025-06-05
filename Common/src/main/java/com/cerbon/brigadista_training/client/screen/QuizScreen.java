package com.cerbon.brigadista_training.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class QuizScreen extends Screen {

    private static final int TOTAL_QUESTIONS = 20;

    private record Question(String text, String[] answers, int correctIndex) {}

    private final List<Question> questions = List.of(
            // index 1
            new Question(
                    "Qual objeto descartado na mata pode concentrar os raios solares como uma lente e iniciar um incêndio?",
                    new String[]{
                            "Papelão úmido",
                            "Garrafa ou caco de vidro",
                            "Pedra calcária",
                            "Lata de alumínio"
                    },
                    1
            ),
            // index 3
            new Question(
                    "Por que bitucas de cigarro representam um risco de fogo em áreas de vegetação seca?",
                    new String[]{
                            "Aceleram o crescimento de plantas",
                            "Apagam-se instantaneamente",
                            "Neutralizam outros focos de calor",
                            "Mantêm brasa acesa que pode inflamar o capim"
                    },
                    3
            ),
            // index 0
            new Question(
                    "A probabilidade de uma bituca causar incêndio aumenta quando…",
                    new String[]{
                            "Muitas bitucas são jogadas em vegetação seca",
                            "A umidade relativa está alta",
                            "Há chuva constante",
                            "O filtro foi removido antes do descarte"
                    },
                    0
            ),
            // index 2
            new Question(
                    "Qual prática típica das festas juninas é ilegal e uma das maiores causas de incêndios na vegetação paulista?",
                    new String[]{
                            "Fogueira de São João",
                            "Rojões",
                            "Soltar balões juninos",
                            "Quadrilha com tochas"
                    },
                    2
            ),
            // index 3
            new Question(
                    "Mesmo “apagada”, uma fogueira pode iniciar queimadas porque…",
                    new String[]{
                            "A cinza esfria muito rápido",
                            "A terra ao redor fica úmida",
                            "A areia cobre totalmente as chamas",
                            "Brasas ficam ativas por horas e o vento espalha fagulhas"
                    },
                    3
            ),
            // index 0
            new Question(
                    "Cabos elétricos caídos são perigosos em áreas de mata porque…",
                    new String[]{
                            "Geram faíscas/curto-circuito que incendeiam o mato seco",
                            "Irradiam água",
                            "Produzem sombra intensa",
                            "Atraem insetos combustíveis"
                    },
                    0
            ),
            // index 2
            new Question(
                    "A cor amarela do uniforme do brigadista serve principalmente para…",
                    new String[]{
                            "Camuflagem entre árvores",
                            "Absorver suor",
                            "Alta visibilidade em fumaça e pouca luz",
                            "Reduzir peso do tecido"
                    },
                    2
            ),
            // index 1
            new Question(
                    "Jaqueta e calça dos brigadistas são confeccionadas, em geral, com tecido retardante de chamas à base de…",
                    new String[]{
                            "Poliéster comum",
                            "Nomex® ou algodão tratado",
                            "Algodão cru",
                            "Nylon fino"
                    },
                    1
            ),
            // index 0
            new Question(
                    "As faixas refletivas aplicadas no uniforme têm a função de…",
                    new String[]{
                            "Facilitar a localização da equipe em visibilidade reduzida",
                            "Impermeabilizar a roupa",
                            "Absorver radiação ultravioleta",
                            "Diminuir a temperatura corporal"
                    },
                    0
            ),
            // index 2
            new Question(
                    "Luvas, botas e capacete completam o EPI para…",
                    new String[]{
                            "Decorar a farda",
                            "Armazenar água",
                            "Isolar calor, evitar cortes e proteger contra quedas de galhos",
                            "Prender ferramentas pesadas"
                    },
                    2
            ),
            // index 1
            new Question(
                    "A radiação térmica em um incêndio florestal pode ultrapassar que temperatura, capaz de pôr a missão em risco sem EPI adequado?",
                    new String[]{
                            "200 °C",
                            "800 °C",
                            "400 °C",
                            "1000 °C"
                    },
                    1
            ),
            // index 3
            new Question(
                    "Na primeira missão de treinamento, quantos objetos causadores de queimadas o recruta deve coletar?",
                    new String[]{
                            "Cinco",
                            "Quinze",
                            "Vinte",
                            "Dez"
                    },
                    3
            ),
            // index 2
            new Question(
                    "Qual dos itens abaixo NÃO foi citado como potencial causador de queimadas a ser coletado?",
                    new String[]{
                            "Bituca de cigarro",
                            "Galão de combustível",
                            "Garrafa de água plástica cheia",
                            "Caco de vidro"
                    },
                    2
            ),
            // index 0
            new Question(
                    "Onde começa a missão do recruta segundo o Professor Almeida?",
                    new String[]{
                            "Floresta de treinamento após o portão leste",
                            "Vila ribeirinha",
                            "Depósito de equipamentos",
                            "Torre de observação"
                    },
                    0
            ),
            // index 1
            new Question(
                    "Depois de coletar os objetos, o recruta deve levá-los ao…",
                    new String[]{
                            "Quartel-general central",
                            "Posto-avançado do instrutor",
                            "Caminhão-pipa",
                            "Laboratório móvel"
                    },
                    1
            ),
            // index 3
            new Question(
                    "Além de combater chamas, uma função dos brigadistas é…",
                    new String[]{
                            "Pintar aceiros",
                            "Vender EPIs",
                            "Cortar lenha para acampamentos",
                            "Monitorar focos de calor e registrar ocorrências"
                    },
                    3
            ),
            // index 0
            new Question(
                    "Em emergências, brigadistas também prestam…",
                    new String[]{
                            "Primeiros socorros e suporte logístico",
                            "Serviços bancários",
                            "Aulas de direção",
                            "Policiamento de trânsito"
                    },
                    0
            ),
            // index 2
            new Question(
                    "O design leve e ergonômico do uniforme visa garantir…",
                    new String[]{
                            "Moda sustentável",
                            "Redução do preço final",
                            "Mobilidade durante horas de combate ao fogo",
                            "Resistência química a ácidos fortes"
                    },
                    2
            ),
            // index 1
            new Question(
                    "Segundo o Professor Almeida, qual é a “melhor ferramenta contra o fogo”?",
                    new String[]{
                            "Mangueira de alta pressão",
                            "Conhecimento",
                            "Extintor ABC",
                            "Drone de vigilância"
                    },
                    1
            ),
            // index 3
            new Question(
                    "Dentre as opções, qual NÃO costuma iniciar incêndios?",
                    new String[]{
                            "Fogueira mal apagada",
                            "Cabo elétrico caído",
                            "Balão junino em chamas",
                            "Camiseta de algodão jogada na grama"
                    },
                    3
            )
    );

    private int current = 0;
    private int correct = 0;
    private final List<Button> answerButtons = new ArrayList<>();

    private Button finishButton;

    public QuizScreen() {
        super(Component.literal("Quiz Queimadas"));
    }

    @Override
    protected void init() {
        super.init();
        answerButtons.clear();

        int bw = 200;
        int bh = 20;
        int startY = height / 2 - 40;

        for (int i = 0; i < 4; i++) {
            final int answerIndex = i;
            Button btn = Button.builder(Component.literal(""),
                            b -> handleAnswer(answerIndex))
                    .bounds(width / 2 - bw / 2,
                            startY + i * (bh + 5),
                            bw, bh)
                    .build();
            answerButtons.add(addRenderableWidget(btn));
        }

        finishButton = addRenderableWidget(
                Button.builder(Component.literal("Finish"), b -> onClose()) //TODO: Save score in the database
                        .bounds(width / 2 - 40, height / 2 + 30, 80, 20)
                        .build());
        finishButton.visible = false;

        updateQuestion();
    }

    private void handleAnswer(int chosen) {
        if (isFinished()) return;
        Question q = questions.get(current);
        if (chosen == q.correctIndex) correct++;
        current++;
        if (isFinished()) {
            showResult();
        } else {
            updateQuestion();
        }
    }

    /* Refresh button labels for the current question */
    private void updateQuestion() {
        Question q = questions.get(current);
        for (int i = 0; i < 4; i++) {
            answerButtons.get(i).setMessage(Component.literal(q.answers[i]));
            answerButtons.get(i).visible = true;
        }
    }

    /* Hide buttons and let render() paint the score line */
    private void showResult() {
        answerButtons.forEach(b -> b.visible = false);
        finishButton.visible = true;
    }

    private boolean isFinished() {
        return current >= TOTAL_QUESTIONS;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        if (!isFinished()) {
            guiGraphics.drawCenteredString(
                    font,
                    questions.get(current).text,
                    width / 2, height / 2 - 60,
                    0xFFFFFF
            );

            String progress = (current + 1) + " / " + TOTAL_QUESTIONS;
            guiGraphics.drawCenteredString(
                    font,
                    progress,
                    width / 2,
                    height / 2 - 75,
                    0xAAAAAA
            );
        } else {
            guiGraphics.drawCenteredString(
                    font,
                    "Você acertou " + correct + " de " + TOTAL_QUESTIONS + "!",
                    width / 2,
                    height / 2 - 10,
                    0x00FF00
            );
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
