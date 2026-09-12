
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ManipuladorImagem {

    private BufferedImage imagem;
    private int largura;
    private int altura;
    private int contadorFrames = 0;
    private File pastaFrames;


    public ManipuladorImagem(String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        this.imagem = ImageIO.read(arquivo);
        this.largura = imagem.getWidth();
        this.altura = imagem.getHeight();

        // Cria uma pasta para salvar os frames da animação
        this.pastaFrames = new File("frames_animacao");
        if (!pastaFrames.exists()) {
            pastaFrames.mkdir();
        }
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    // Retorna a cor RGB de um pixel específico
    public int getCor(int x, int y) {
        return imagem.getRGB(x, y);
    }

    // Altera a cor de um pixel na matriz
    public void setCor(int x, int y, int novaCor) {
        imagem.setRGB(x, y, novaCor);
    }

    // Verifica se a coordenada está dentro dos limites da imagem
    public boolean coordenadaValida(int x, int y) {
        return x >= 0 && x < largura && y >= 0 && y < altura;
    }

    // Salva o resultado final da imagem
    public void salvarImagemFinal(String caminhoSaida) throws IOException {
        File arquivoSaida = new File(caminhoSaida);
        ImageIO.write(imagem, "png", arquivoSaida);
    }

    // Salva um frame intermediário para a animação (com controle de frequência para imagens grandes)
    public void salvarFrameAnimacao(int frequencia) {
        contadorFrames++;
        if (contadorFrames % frequencia == 0) {
            try {
                String nomeArquivo = String.format("frames_animacao/frame_%06d.png", contadorFrames);
                ImageIO.write(imagem, "png", new File(nomeArquivo));
            } catch (IOException e) {
                System.out.println("Erro ao salvar frame da animação: " + e.getMessage());
            }
        }
    }
}