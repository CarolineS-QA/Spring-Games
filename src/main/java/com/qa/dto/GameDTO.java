package com.qa.dto;

import java.math.BigDecimal;
import java.util.Date;

public class GameDTO {

    private Long gameId;
    private String title;
    private String description;
    private Date releaseDate;
    private BigDecimal price;

    public GameDTO() {
    }

    public GameDTO(String title, String description, Date releaseDate, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.price = price;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
