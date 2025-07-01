package local.antropodus.models;

import local.antropodus.enums.RutaHabilidad;

/**
 *
 * @author sergio
 */
public class PlayerData {

    private float exp;
    private Skill[] skills;
    private RutaHabilidad especialidad;

    PlayerData() {
        this.exp = 0;
    }

}
