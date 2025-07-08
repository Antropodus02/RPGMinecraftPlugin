package local.antropodus.models;

import java.util.UUID;

import local.antropodus.enums.RutaHabilidad;

public class PlayerData {
    public UUID uuid;
    public float actualExp;
    public float neededExp;
    public int level;
    public Skill[] habilidades;
    public RutaHabilidad especialidad;

    public PlayerData(UUID uuid, float actualExp, float neededExp, int level, Skill[] habilidades,
            RutaHabilidad especiliadad) {
        this.uuid = uuid;
        this.actualExp = actualExp;
        this.neededExp = neededExp;
        this.level = level;
        this.habilidades = habilidades;
        this.especialidad = especiliadad;
    }
}
