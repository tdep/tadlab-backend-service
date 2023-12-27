package com.tdep.tadlab.backendservice.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentConstructor {
  Dotenv dotenv = Dotenv.configure()
      .directory("/")
      .filename("env")
      .load();

  public String getUser () {
    return dotenv.get("POSTGRES_USER");
  }

  public String getPWD () {
    return dotenv.get("POSTGRES_PWD");
  }

  public String getDB () {
    return dotenv.get("POSTGRES_DB");
  }

  public String getURL () {
    return dotenv.get("POSTGRES_URL");
  }
}
