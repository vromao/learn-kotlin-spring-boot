package com.acme.tour.service.impl

import com.acme.tour.model.Promocao
import com.acme.tour.service.PromocaoService
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl: PromocaoService {
    companion object {
        val initialPromocoes = arrayOf(
            Promocao(1, "Maravilhosa viagem", "cancun", true, 7,7.400),
            Promocao(2, "Viagem tosca", "nada", false, 1,10.00),
            Promocao(3, "Que viagem legal", "São Paulo", false, 20,500.00),
            Promocao(4, "Venha aproveitar essa viagem", "Rio de Janeiro", false, 14,1000.00),
        )
    }

    val promocoes = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))

    override fun create(promocao: Promocao) {
        promocoes[promocao.id] = promocao
    }

    override fun getById(id: Long): Promocao? = promocoes[id]

    override fun delete(id: Long) {
        promocoes.remove(id)
    }

    override fun update(id: Long, promocao: Promocao) {
        delete(id)
        create(promocao)
    }

    override fun searchByLocal(local: String): List<Promocao> =
        promocoes.filter {
            it.value.local.contains(local, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()

}