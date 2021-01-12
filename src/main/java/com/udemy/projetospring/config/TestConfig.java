package com.udemy.projetospring.config;

import java.time.Instant;
import java.util.Arrays;

import com.udemy.projetospring.entities.Categoria;
import com.udemy.projetospring.entities.Pedido;
import com.udemy.projetospring.entities.Produto;
import com.udemy.projetospring.entities.Usuario;
import com.udemy.projetospring.entities.enums.PedidoStatus;
import com.udemy.projetospring.repositories.CategoriaRepository;
import com.udemy.projetospring.repositories.PedidoRepository;
import com.udemy.projetospring.repositories.ProdutoRepository;
import com.udemy.projetospring.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = new Usuario(null, "João", "joao@gmail.com", "999778844", "123456");
        Usuario usuario2 = new Usuario(null, "Maria", "maria@gmail.com", "988775522", "654321");

        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, usuario);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.ENTREGUE, usuario2);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, usuario);

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));
        pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

}
