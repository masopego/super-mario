package com.penagomez.supermario;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCharacterRepository implements CharacterRepository {

    private List<SuperMarioData> characters = new ArrayList<SuperMarioData>();

    public InMemoryCharacterRepository() {

        characters.add(
                new SuperMarioData(R.drawable.mario, "Super Mario", "El héroe principal, famoso por su valentía, habilidades de salto y rescatar a la Princesa Peach.")
        );
        characters.add(
                new SuperMarioData(R.drawable.luigi, "Luigi", "Hermano de Mario, ligeramente más alto y conocido por su carácter tímido pero valiente.")
        );
        characters.add(
                new SuperMarioData(R.drawable.peach, "Princess Peach", "La princesa del Reino Champiñón, secuestrada frecuentemente por Bowser, pero siempre rescatada por Mario.")
        );
        characters.add(
                new SuperMarioData(R.drawable.bowser, "Bowser", "El rey de los Koopas, villano principal que intenta apoderarse del Reino Champiñón y secuestra a Peach.")
        );
        characters.add(
                new SuperMarioData(R.drawable.yoshi, "Yoshi", "Un fiel dinosaurio que ayuda a Mario y Luigi en sus aventuras, conocido por su habilidad para tragarse enemigos.")
        );
        characters.add(
                new SuperMarioData(R.drawable.toad, "Toad", "Habitante y guardián del Reino Champiñón que asiste a Mario y Peach.")
        );
        characters.add(
                new SuperMarioData(R.drawable.donkey_kong, "Donkey Kong", "Un gorila grande y fuerte que fue inicialmente un rival de Mario, pero ahora es un aliado ocasional.")
        );
        characters.add(
                new SuperMarioData(R.drawable.wario, "Wario", "El rival de Mario, egoísta y ambicioso, siempre buscando maneras de enriquecerse.")
        );
        characters.add(
                new SuperMarioData(R.drawable.waluigi, "Waluigi", "El hermano de Wario, conocido por su envidia hacia Luigi y sus travesuras.")
        );
        characters.add(
                new SuperMarioData(R.drawable.daisy, "Princess Daisy", "La princesa del Reino Sarasaland y amiga de Peach, valiente y extrovertida.")
        );
        characters.add(
                new SuperMarioData(R.drawable.koopa_troopa, "Koopa Troopa", "Un enemigo común en el Reino Champiñón, que tiene un caparazón que puede usarse como arma cuando es golpeado.")
        );
        characters.add(
                new SuperMarioData(R.drawable.goomba, "Goomba", "Un enemigo clásico de Mario, pequeño pero persistente en bloquear su camino.")
        );
        characters.add(
                new SuperMarioData(R.drawable.bowserjr, "Bowser Jr.", "Hijo de Bowser, con un fuerte deseo de impresionar a su padre y seguir sus pasos.")
        );
        characters.add(
                new SuperMarioData(R.drawable.rosalina, "Rosalina", "Guardiana del cosmos y amiga de Mario, acompaña a los Lumas en sus aventuras espaciales.")
        );
        characters.add(
                new SuperMarioData(R.drawable.lakitu, "Lakitu", "Un Koopa que vuela en una nube y arroja espinas a Mario, a veces ayuda como camarógrafo en Mario Kart.")
        );
    }

    @Override
    public List<SuperMarioData> findAll() {
        return characters;
    }
}
