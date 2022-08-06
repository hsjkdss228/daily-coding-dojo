import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pokemon {
  public int solution(int[] pokemons) {
    Map<Integer, Integer> pokemonRepository = new HashMap<>();

    Arrays.stream(pokemons)
        .forEach(pokemon -> {
          if (pokemonRepository.containsKey(pokemon)) {
            pokemonRepository.replace(
                pokemon, pokemonRepository.get(pokemon) + 1);
          } else {
            pokemonRepository.put(pokemon, 1);
          }
        });

    int numberPokemonCanChoose = pokemons.length / 2;

//    아래의 조건에 따른 반환 분기는 다음으로 대체 가능
//    return Math.min(pokemonRepository.size(), numberPokemonCanChoose);

    if (pokemonRepository.size() >= numberPokemonCanChoose) {
      return numberPokemonCanChoose;
    }

    return pokemonRepository.size();
  }
}
