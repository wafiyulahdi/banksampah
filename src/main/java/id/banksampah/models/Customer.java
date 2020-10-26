package id.banksampah;

import id.banksampah.models.UserModels;

class Customer extends UserModels {
    
    public String userLevel="";

    public Customer() {

    }

    public void setUserLevel(String level) {
      this.userLevel = level;
    }
    
    public String getUserLevel() {
      return this.userLevel;
    }

    public String checkParentClass() {
      return super.getClass().getName();
    }

    public boolean checkSubClass(Object candidate, Class<?> type) {
      return type.isInstance(candidate);
    }
}