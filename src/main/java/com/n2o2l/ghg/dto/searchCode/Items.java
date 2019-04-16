/**
  * Copyright 2019 bejson.com 
  */
package com.n2o2l.ghg.dto.searchCode;

import java.util.Objects;

/**
 * Auto-generated: 2019-01-13 7:50:20
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Items {

    private String name;
    private String path;
    private String sha;
    private String url;
    private String git_url;
    private String html_url;
    private Repository repository;
    private double score;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setPath(String path) {
         this.path = path;
     }
     public String getPath() {
         return path;
     }

    public void setSha(String sha) {
         this.sha = sha;
     }
     public String getSha() {
         return sha;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setGit_url(String git_url) {
         this.git_url = git_url;
     }
     public String getGit_url() {
         return git_url;
     }

    public void setHtml_url(String html_url) {
         this.html_url = html_url;
     }
     public String getHtml_url() {
         return html_url;
     }

    public void setRepository(Repository repository) {
         this.repository = repository;
     }
     public Repository getRepository() {
         return repository;
     }

    public void setScore(double score) {
         this.score = score;
     }
     public double getScore() {
         return score;
     }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return Double.compare(items.score, score) == 0 &&
                Objects.equals(name, items.name) &&
                Objects.equals(path, items.path) &&
                Objects.equals(sha, items.sha) &&
                Objects.equals(url, items.url) &&
                Objects.equals(git_url, items.git_url) &&
                Objects.equals(html_url, items.html_url) &&
                Objects.equals(repository, items.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, sha, url, git_url, html_url, repository, score);
    }
}