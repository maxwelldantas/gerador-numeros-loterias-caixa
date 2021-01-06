import java.lang.StringBuilder
import java.util.*

fun main() {

    val input = Scanner(System.`in`)
    var quantidadeJogos = 0

    println("*** Seja muito bem vindo(a) aos números da sorte da Lotofácil ***\n" +
            "*** Com estes números que serão gerados tomará que a sorte te faça ganhador deste concurso!!! ***")
    print("Digite a quantidade de jogos a serem gerados: ")
    for (j in 1 until (input.nextInt() + 1)) {
        val lotofacil = Lotofacil()
        val numerosQueSeraoSorteadosLotofacil = lotofacil.numerosQueSeraoSorteadosLotofacil
        while (numerosQueSeraoSorteadosLotofacil.size != 15) {
            val x = lotofacil.numeros.random().toString().toInt()
            if (!numerosQueSeraoSorteadosLotofacil.contains(x)) {
                numerosQueSeraoSorteadosLotofacil.add(x)
            }
        }

        numerosQueSeraoSorteadosLotofacil.sort()
        val sb = StringBuilder()
        for (x in 0 until numerosQueSeraoSorteadosLotofacil.size) {
            val umAnove = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
            if (umAnove.contains(numerosQueSeraoSorteadosLotofacil[x])) {
                sb.append("0${numerosQueSeraoSorteadosLotofacil[x]}")
                if (x != numerosQueSeraoSorteadosLotofacil.size - 1) {
                    sb.append(" ")
                }
            } else {
                sb.append("${numerosQueSeraoSorteadosLotofacil[x]}")
                if (x != numerosQueSeraoSorteadosLotofacil.size - 1) {
                    sb.append(" ")
                }
            }
        }
        print("Jogo número $j: ")
        println(sb)
        quantidadeJogos = j
    }

    val valorJogos = 2.50F * quantidadeJogos
    println("Custo para realizar este(s) jogo(s): R$ $valorJogos")

    if (valorJogos >= 30.0) {
        println("Com este custo estes jogos podem ser apostados na Loterias CAIXA online")
    } else {
        println("Com este custo este(s) jogo(s) não pode(m) ser apostado(s) na Loterias CAIXA online")
    }

}