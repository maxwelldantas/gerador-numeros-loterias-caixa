import java.lang.StringBuilder
import java.util.*

fun main() {

    val input = Scanner(System.`in`)

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

        // Ordenando números na lista
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
    }

}