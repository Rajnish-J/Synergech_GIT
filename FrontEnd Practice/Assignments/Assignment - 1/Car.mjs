class AutoMobile {
  constructor(autoMobileType, fuelType) {
    this.autoMobileType = autoMobileType;
    this.fuelType = fuelType;
  }

  displayDetails() {
    console.log(`AutoMobile Type: ${this.autoMobileType}`);
    console.log(`FuelType Type: ${this.fuelType}`);
  }
}

export default class Car extends AutoMobile {
  constructor(autoMobileType, fuelType, carType, carBrand) {
    super(autoMobileType, fuelType);
    this.carType = carType;
    this.carBrand = carBrand;
  }

  displayCarDetails() {
    this.displayDetails();
    console.log(`Car Type: ${this.carType}`);
    console.log(`Car Brand: ${this.carBrand}`);
  }
}