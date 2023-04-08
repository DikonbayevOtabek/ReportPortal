package com.epam.reportportal.product.http.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties({"owner", "widgets", "description"})
public class DashboardResponseBody {

  private boolean share;
  private String name;
  private String id;

  public DashboardResponseBody() {
  }

  public DashboardResponseBody(boolean share, String name, String id) {
    this.id = id;
    this.share = share;
    this.name = name;
  }

  public boolean getShare() {
    return share;
  }

  public void setShare(boolean share) {
    this.share = share;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DashboardResponseBody that = (DashboardResponseBody) o;
    return share == that.share && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(share, name);
  }

  @Override
  public String toString() {
    return "DashboardResponseBody{" +
            "share=" + share +
            ", name='" + name + '\'' +
            '}';
  }

}
