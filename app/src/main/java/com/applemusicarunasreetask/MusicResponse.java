package com.applemusicarunasreetask;

import java.util.List;

public class MusicResponse {

    Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    class Feed {
        private String title;
        private String id;
        private Author author;
        private List<Link> links;
        private String copyright;
        private String country;
        private String icon;
        private String updated;
        private List<MusicDetails> results;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public List<Link> getLinks() {
            return links;
        }

        public void setLinks(List<Link> links) {
            this.links = links;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<MusicDetails> getResults() {
            return results;
        }

        public void setResults(List<MusicDetails> results) {
            this.results = results;
        }

        public class Author{
            private String name;
            private String uri;
        }

        public class Link{
            private String self;
        }

        public class MusicDetails {
            private String artistName;
            private String id;
            private String releaseDate;
            private String name;
            private String kind;
            private String copyright;
            private String artistId;
            private String artistUrl;
            private String artworkUrl100;
            private List<MusicDetails.Genre> genres;
            private String url;


            public String getArtistName() {
                return artistName;
            }

            public void setArtistName(String artistName) {
                this.artistName = artistName;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(String releaseDate) {
                this.releaseDate = releaseDate;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public String getArtistId() {
                return artistId;
            }

            public void setArtistId(String artistId) {
                this.artistId = artistId;
            }

            public String getArtistUrl() {
                return artistUrl;
            }

            public void setArtistUrl(String artistUrl) {
                this.artistUrl = artistUrl;
            }

            public String getArtworkUrl100() {
                return artworkUrl100;
            }

            public void setArtworkUrl100(String artworkUrl100) {
                this.artworkUrl100 = artworkUrl100;
            }

            public List<MusicDetails.Genre> getGenres() {
                return genres;
            }

            public void setGenres(List< MusicDetails.Genre > genres) {
                this.genres = genres;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            class Genre{
                private String genreId;
                private String name;
                private String url;

                public String getGenreId() {
                    return genreId;
                }

                public void setGenreId(String genreId) {
                    this.genreId = genreId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
