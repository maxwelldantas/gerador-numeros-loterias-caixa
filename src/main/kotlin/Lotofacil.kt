import java.io.File
import java.lang.StringBuilder
import java.time.LocalDateTime
import kotlin.collections.ArrayList

class Lotofacil {

    val numeros = (1..25)
    val numerosQueSeraoSorteadosLotofacil: ArrayList<Int> = ArrayList()

    companion object {
        fun jogosLotofacil(quantidadeJogos: Int) {
            val jogosParaGravar = StringBuilder()

            for (j in 1 until (quantidadeJogos + 1)) {
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
                jogosParaGravar.append("Jogo número $j: ".plus(sb.append("\n")))
            }

            gravarJogos(jogosParaGravar)

            val valorJogos = 2.50F * quantidadeJogos
            println("Custo para realizar este(s) jogo(s): R$ $valorJogos")

            if (valorJogos >= 30.0) {
                println("Com este custo estes jogos podem ser apostados na Loterias CAIXA online")
            } else {
                println("Com este custo este(s) jogo(s) não pode(m) ser apostado(s) na Loterias CAIXA online")
            }
        }

        private fun gravarJogos(sb: StringBuilder) {
            sb.setLength(sb.length - 1)
            val dia = LocalDateTime.now().dayOfMonth
            val mes = LocalDateTime.now().monthValue
            val ano = LocalDateTime.now().year
            val hora = LocalDateTime.now().hour
            val minuto = LocalDateTime.now().minute
            val segundo = LocalDateTime.now().second
            val dataHorario = "$dia-$mes-$ano-${hora}h${minuto}m${segundo}s"
            File("Apostas-Lotofacil-$dataHorario.txt").writeText(sb.toString())
        }
    }
}