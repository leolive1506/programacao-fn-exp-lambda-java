# Comparator
- interface funcional java 8+
  - interface funcional tem apenas um metodo abstrato
  - pode ter metodos, default e estático
    - porem o metodo a ser implementado é somente um
- Comparação pode ser feita por meio do Comparable<Product>
  - porém, a classe não fica fechada a alteração
  - se o critério de comparação mudar, precisa alterar a classe Product

# Interface funcional
- interface funcional tem apenas um metodo abstrato
- suas implementações serão tratadas como expressões lambda
- mapeamento direto com expressões lambda
  - expressõe lambda são tratadas como interface funcional
- Algumas interfaces funcionais
  - Predicate
  - Funcion
  - Consumer
    - ao contrário das interfaces funcionais, é esperado que ele possa gerar efeitso colaterais
    - return void e espera que faça alguma ação

# Predicate
- boolean test(T t)
- remova da lista somente aqueles cujo preço mínimo seja 100.
```java
list.removeIf(product -> product.getPrice() >= 100);
```
# Consumer
- void accept(T t);

# Function
- interface Funcion<Recebe, Retorna>
- Retorna apply(Recebe t)

# Funções que recebem funções como argumento
- exemplo em ProductService.java

# Stream
- Sequencia de elementos advindas de uma fonte de dados que oferece suporte a "operações agregadas"
  - fonte de dados: coleção, array, função de iteração, recurso Entrada / saida
- Solução para processar sequencias de dados de forma
  - declarativa (iteração interna: escondida do programador)
  - parallel-friendly (imutável -> thread safe)
    - facilidade de trabalhar com paralelismo
  - sem efeitos colaterais
  - sob demanda (lazy evaluation)
- Acesso sequencial (não há índices)
- singles use: só pode ser "usada uma vez"
- **Pipeline** (linhas de montagem): 
  - retornam novas streams
  - é possível criar uma cadeia de operações (fluxo de processamento)

## Operações intermediárias ou terminais
- op intermediaria
  - produz uma nova streams (encadeamento)
  - só executa quando uma op terminal é invocada
  - ex:
    - filter
    - map
    - flatmap
    - peek
    - distinct
    - sorted
    - skitp
    - limit (*)
      - short-circuit 
      - corta execução quando condição é satisfeita

- op terminal
  - produz obj não-stream (coleçao ou outro)
  - determina o fim do processamento da stream
  - ex:
    - forEach
    - forEachOrdered
    - toArray
    - reduce
    - collect
    - min
    - max
    - count
    - anyMatch(*)
    - allMatch(*)
    - noneMatch(*)
    - findFirst(*)
    - findAny(*)
- pipeline
  - composto por 0 ou mais op intermediarias e uma op terminal
- Criar um strem basta chamar a partir de qualquer Obj Collection
  - .stream()
  - .parallelStream()