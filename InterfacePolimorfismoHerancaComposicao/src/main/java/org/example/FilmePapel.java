package org.example;

public class FilmePapel {
    private String filme;
    private Papel papel;

    public FilmePapel(String filme, Papel papel){
        this.filme = filme;
        this.papel = papel;
    }

    public FilmePapel(String filme) {
        this.filme = filme;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
}
