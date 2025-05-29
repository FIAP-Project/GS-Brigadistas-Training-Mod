package com.cerbon.brigadista_training.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class QuizScreen extends Screen {

    private static final int TOTAL_QUESTIONS = 10;

    private record Question(String text, String[] answers, int correctIndex) {}

    private final List<Question> questions = List.of(
            new Question("Qual é a principal causa de queimadas no Brasil?",
                    new String[]{
                            "Atividades agrícolas",
                            "Queda de raios",
                            "Eruptões vulcânicas",
                            "Acidentes de trânsito"
                    },
                    0
            ),
            new Question("Que material NÃO deve ser queimado a céu aberto?",
                    new String[]{
                            "Restos de poda",
                            "Resíduos plásticos",
                            "Palha de cana-de-açúcar",
                            "Lenha seca"
                    },
                    1
            ),
            new Question("Qual bioma brasileiro sofre mais com incêndios anuais?",
                    new String[]{
                            "Pantanal",
                            "Pampa",
                            "Mata Atlântica",
                            "Caatinga"
                    },
                    0
            ),
            new Question("Que órgão emite alertas de risco de fogo no Brasil?",
                    new String[]{
                            "INPE",
                            "IBAMA",
                            "CEMIG",
                            "DNIT"
                    },
                    0
            ),
            new Question("Que aparente vantagem falsa leva muitos produtores a queimarem resíduos?",
                    new String[]{
                            "Adubar o solo rapidamente",
                            "Repelir pragas permanentemente",
                            "Aumentar a biodiversidade",
                            "Conservar umidade"
                    },
                    0
            ),
            new Question("Qual equipamento o brigadista SEMPRE deve usar em combate a chamas?",
                    new String[]{
                            "Bombeiro hidráulico",
                            "GPS portátil",
                            "EPI completo",
                            "Extintor de CO₂"
                    },
                    2
            ),
            new Question("Qual destes gases tóxicos é liberado em grandes quantidades em queimadas?",
                    new String[]{
                            "CO",
                            "Ne",
                            "He",
                            "Ar"
                    },
                    0
            ),
            new Question("Que ação preventiva reduz drasticamente focos em áreas rurais?",
                    new String[]{
                            "Aceiro bem-mantenido",
                            "Aplicar fertilizante químico",
                            "Regar à noite",
                            "Soltar gado na mata"
                    },
                    0
            ),
            new Question("Que estação concentra a maioria dos incêndios florestais no Centro-Oeste?",
                    new String[]{
                            "Seca",
                            "Chuvosa",
                            "Inverno astronômico",
                            "Primavera"
                    },
                    0
            ),
            new Question("Qual penalidade pode ser aplicada por provocar queimada ilegal?",
                    new String[]{
                            "Multa e detenção",
                            "Apenas advertência verbal",
                            "Nenhuma",
                            "Suspensão do título de eleitor"
                    },
                    0
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
