package com.penagomez.supermario.data.repository;

import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCharacterRepository implements CharacterRepository {

    private List<Character> characters = new ArrayList<Character>();

    public InMemoryCharacterRepository() {

        characters.add(
                new Character(R.drawable.mario, "Super Mario", "El héroe principal, famoso por su valentía, habilidades de salto y rescatar a la Princesa Peach.", "Salto alto, super fuerza")
        );
        characters.add(
                new Character(R.drawable.luigi, "Luigi", "Hermano de Mario, ligeramente más alto y conocido por su carácter tímido pero valiente.", "Salto alto, deslizamiento")
        );
        characters.add(
                new Character(R.drawable.peach, "Princess Peach", "La princesa del Reino Champiñón, secuestrada frecuentemente por Bowser, pero siempre rescatada por Mario.", "Flotación en el aire, magia")
        );
        characters.add(
                new Character(R.drawable.bowser, "Bowser", "El rey de los Koopas, villano principal que intenta apoderarse del Reino Champiñón y secuestra a Peach.", "Aliento de fuego, gran fuerza")
        );
        characters.add(
                new Character(R.drawable.yoshi, "Yoshi", "Un fiel dinosaurio que ayuda a Mario y Luigi en sus aventuras, conocido por su habilidad para tragarse enemigos.", "Lengua larga, salto extendido")
        );
        characters.add(
                new Character(R.drawable.toad, "Toad", "Habitante y guardián del Reino Champiñón que asiste a Mario y Peach.", "Velocidad, conocimiento del Reino Champiñón")
        );
        characters.add(
                new Character(R.drawable.donkey_kong, "Donkey Kong", "Un gorila grande y fuerte que fue inicialmente un rival de Mario, pero ahora es un aliado ocasional.", "Fuerza bruta, lanzamiento de barriles")
        );
        characters.add(
                new Character(R.drawable.wario, "Wario", "El rival de Mario, egoísta y ambicioso, siempre buscando maneras de enriquecerse.", "Super fuerza, resistencia")
        );
        characters.add(
                new Character(R.drawable.waluigi, "Waluigi", "El hermano de Wario, conocido por su envidia hacia Luigi y sus travesuras.", "Habilidades de trampas, agilidad")
        );
        characters.add(
                new Character(R.drawable.daisy, "Princess Daisy", "La princesa del Reino Sarasaland y amiga de Peach, valiente y extrovertida.", "Super salto, habilidades deportivas")
        );
        characters.add(
                new Character(R.drawable.koopa_troopa, "Koopa Troopa", "Un enemigo común en el Reino Champiñón, que tiene un caparazón que puede usarse como arma cuando es golpeado.", "Defensa con caparazón, ataque giratorio")
        );
        characters.add(
                new Character(R.drawable.goomba, "Goomba", "Un enemigo clásico de Mario, pequeño pero persistente en bloquear su camino.", "Ataque en grupo, tenacidad")
        );
        characters.add(
                new Character(R.drawable.bowserjr, "Bowser Jr.", "Hijo de Bowser, con un fuerte deseo de impresionar a su padre y seguir sus pasos.", "Pintura mágica, habilidades en batalla")
        );
        characters.add(
                new Character(R.drawable.rosalina, "Rosalina", "Guardiana del cosmos y amiga de Mario, acompaña a los Lumas en sus aventuras espaciales.", "Poderes cósmicos, levitación")
        );
        characters.add(
                new Character(R.drawable.lakitu, "Lakitu", "Un Koopa que vuela en una nube y arroja espinas a Mario, a veces ayuda como camarógrafo en Mario Kart.", "Volar en nubes, lanzar espinas")
        );
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }
}
