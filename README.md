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