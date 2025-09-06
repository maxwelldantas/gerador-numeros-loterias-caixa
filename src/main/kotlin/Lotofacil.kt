import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Lotofacil {
    private const val VALOR_JOGO = 3.5
    private const val VALOR_MINIMO_ONLINE = 30.0
    private val NUMEROS_POSSIVEIS = (1..25).toList()

    fun gerarJogos(quantidadeJogos: Int) {
        val jogosGerados = (1..quantidadeJogos).map { indice ->
            val numerosSorteados = NUMEROS_POSSIVEIS.shuffled().take(15).sorted()
            val jogoFormatado = numerosSorteados.joinToString(" ") { numero ->
                "%02d".format(numero)
            }
            "Jogo número $indice: $jogoFormatado"
        }

        val conteudoArquivo = jogosGerados.joinToString("\n")

        println(conteudoArquivo)

        gravarJogos(conteudoArquivo)

        val custoTotal = VALOR_JOGO * quantidadeJogos
        println("\nCusto para realizar este(s) jogo(s): R$ %.2f".format(custoTotal))

        if (custoTotal >= VALOR_MINIMO_ONLINE) {
            println("Com este custo, estes jogos podem ser apostados na Loterias CAIXA online.")
        } else {
            println("Com este custo, este(s) jogo(s) não pode(m) ser apostado(s) na Loterias CAIXA online.")
        }
    }

    private fun gravarJogos(conteudo: String) {
        try {
            val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH'h'mm'm'ss's'"))
            val arquivo = File("apostas/Apostas-Lotofacil-$timestamp.txt")

            arquivo.parentFile.mkdirs()

            arquivo.writeText(conteudo)
            println("Jogos gravados com sucesso em: ${arquivo.absolutePath}")
        } catch (e: Exception) {
            println("Ocorreu um erro ao gravar o arquivo: ${e.message}")
            e.printStackTrace()
        }
    }
}
