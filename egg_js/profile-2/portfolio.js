var Portfolio = /** @class */ (function () {
    function Portfolio(value1, value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    Portfolio.prototype.add = function () {
        if (typeof this.value1 === "string" && !isNaN(Number(this.value1)) && !isNaN(Number(this.value2))) {
            return Number(this.value1) + Number(this.value2);
        }
        else if (typeof this.value1 === "number" && typeof this.value2 === "number") {
            return this.value1 + this.value2;
        }
        else {
            console.error("ERROR: Not a number");
        }
    };
    return Portfolio;
}());
var pStringNums = new Portfolio("2", "3");
var pStringNaN = new Portfolio("2", "x");
// const pDiffTypes = new Portfolio(2, "3");
var pNums = new Portfolio(2, 3);
console.log("StringNums: ", pStringNums.add());
console.log("StringNan: ", pStringNaN.add());
console.log("Nums: ", pNums.add());
