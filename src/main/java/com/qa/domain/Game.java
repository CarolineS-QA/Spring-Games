package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String title;
    private String description;
    private Date releaseDate;
    private String platforms; // list?? pc: y, xbox: n, ps: y, switch: n
    private BigDecimal price;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(getGameId(), game.getGameId()) &&
                Objects.equals(getTitle(), game.getTitle()) &&
                Objects.equals(getDescription(), game.getDescription()) &&
                Objects.equals(getReleaseDate(), game.getReleaseDate()) &&
                Objects.equals(getPlatforms(), game.getPlatforms()) &&
                Objects.equals(getPrice(), game.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getDescription(), getReleaseDate(), getPlatforms(), getPrice());
    }
}
