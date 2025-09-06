import java.util.*

fun main() {

    val input = Scanner(System.`in`)

    println(
        "*** Seja muito bem vindo(a) aos números do azar das Loterias Caixa ***\n" +
        "*** Com estes números que serão gerados tomará que o azar lhe conceda a sorte!!! ***"
    )

    println("Digite o número de qual concurso quer apostar:")
    println("1 - Mega-Sena")
    println("2 - Lotofácil")

    val jogo = input.nextInt()

    print("Digite a quantidade de jogos a serem gerados: ")
    val quantidadeJogos = input.nextInt()

    when (jogo) {
        1 -> MegaSena.gerarJogos(quantidadeJogos)
        2 -> Lotofacil.gerarJogos(quantidadeJogos)
    }
}
