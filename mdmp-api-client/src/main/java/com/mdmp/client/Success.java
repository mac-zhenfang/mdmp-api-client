package com.mdmp.client;

/**
 * Class Description
 *
 * @author Denny Ye
 * @since 2012-11-21
 * @version 1.0
 */
public class Success {
  private String result = "success";

  public boolean isSuccess() {
    return result.equals("success");
  }

  public void setResult(String result) {
    this.result = result;
  }

}
