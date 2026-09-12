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

    // Construtor agora recebe o caminho da imagem E o nome da pasta de frames
    public ManipuladorImagem(String caminhoArquivo, String nomePastaFrames) throws IOException {
        File arquivo = new File(caminhoArquivo);
        this.imagem = ImageIO.read(arquivo);
        this.largura = imagem.getWidth();
        this.altura = imagem.getHeight();

        // Cria a pasta específica pra frames_pilha ou frames_fila
        this.pastaFrames = new File(nomePastaFrames);
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

    public int getCor(int x, int y) {
        return imagem.getRGB(x, y);
    }

    public void setCor(int x, int y, int novaCor) {
        imagem.setRGB(x, y, novaCor);
    }

    public boolean coordenadaValida(int x, int y) {
        return x >= 0 && x < largura && y >= 0 && y < altura;
    }

    public void salvarImagemFinal(String caminhoSaida) throws IOException {
        File arquivoSaida = new File(caminhoSaida);
        ImageIO.write(imagem, "png", arquivoSaida);
    }


    public void salvarFrameAnimacao(int frequencia) {
        contadorFrames++;
        if (contadorFrames % frequencia == 0) {
            try {
                // Usa o caminho da pasta
                String nomeArquivo = String.format("%s/frame_%06d.png", pastaFrames.getPath(), contadorFrames);
                ImageIO.write(imagem, "png", new File(nomeArquivo));
            } catch (IOException e) {
                System.out.println("Erro ao salvar frame da animação: " + e.getMessage());
            }
        }
    }
}