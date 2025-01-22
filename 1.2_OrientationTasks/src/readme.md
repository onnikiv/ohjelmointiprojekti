## Task 1   
a) Saapumistapahtuma luo uuden saapumistapahtuman, koska järjestelmän jatkuvuus vaatii uusien saapumisten simulointia. Tämä mallintaa esimerkiksi asiakkaiden tai tehtävien jatkuvaa virtaa järjestelmässä.

b) Palvelun alkaminen luo poistumistapahtuman, joka merkitsee palvelun päättymistä ja resurssien vapautumista seuraaville yksiköille.

## Task 4

### Init, Clock 0
### **State Table**
| Phase  | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 |
|--------|--------------|--------|--------------|--------|--------------|--------|
| Empty  | Idle         | Empty  | Idle         | Empty  | Idle         | Empty  |

### **Event List**
| Event | Time |
|-------|------|
| B1    | 5    |
| B2    | 10   |

### **Results**
| Work Complete |   |
|:-------------|:--:|
| X | 0 |
| Y | 0 |


## Clock 5: Event B1
### **State Table**
| Phase  | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 |
|--------|--------------|--------|--------------|--------|--------------|--------|
| B      | X1           | Idle   | Empty        | Idle   | Empty        | Idle   |
| C      | Empty        | X1     | Empty        | Idle   | Empty        | Idle   |

### **Event List**
| Event | Time |
|-------|------|
| B3    | 6    |
| B2    | 10   |
| B1    | 10   |

### **Results**
| Work Complete |   |
|:-------------|:--:|
| X | 0 |
| Y | 0 |

---

## Clock 6: Event B3
### **State Table**
| Phase  | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 |
|--------|--------------|--------|--------------|--------|--------------|--------|
| B      | Empty        | Idle   | X1           | Idle   | Empty        | Idle   |
| C      | Empty        | Idle   | Empty        | X1     | Empty        | Idle   |

### **Event List**
| Event | Time |
|-------|------|
| B2    | 10   |
| B1    | 10   |
| B4    | 10   |

### **Results**
| Work Complete |   |
|:-------------|:--:|
| X | 0 |
| Y | 0 |


---

## Clock 10: Events B2, B1, B4
### **State Table**
| Phase  | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 |
|--------|--------------|--------|--------------|--------|--------------|--------|
| B      | X2, Y1       | Idle   | Empty        | Idle   | Empty        | Idle   |
| C      | X2           | Y1     | Empty        | Idle   | Empty        | Idle   |

### **Event List**
| Event | Time |
|-------|------|
| B3    | 11   |
| B1    | 15   |
| B2    | 20   |

### **Results**
| Work Complete |   |
|:-------------|:--:|
| X | 1 |
| Y | 0 |

---

## Clock 11: Event B3
### **State Table**
| Phase  | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 |
|--------|--------------|--------|--------------|--------|--------------|--------|
| B      | X2           | Idle   | Empty        | Idle   | Y1           | Idle   |
| C      | Empty        | X2     | Empty        | Idle   | Empty        | Y1     |

### **Event List**
| Event | Time |
|-------|------|
| B1    | 15   |
| B5    | 18   |
| B2    | 20   |

### **Results**
| Work Complete |   |
|:-------------|:--:|
| X | 1 |
| Y | 0 |


---

## Clock 18: Event B5
### **State Table**
| Phase  | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 |
|--------|--------------|--------|--------------|--------|--------------|--------|
| B      | X2           | Idle   | Empty        | Idle   | Empty        | Idle   |
| C      | Empty        | X2     | Empty        | Idle   | Empty        | Idle   |

### **Event List**
| Event | Time |
|-------|------|
| B1    | 15   |
| B2    | 20   |

### **Results**
| Work Complete |   |
|:-------------|:--:|
| X | 1 |
| Y | 1 |



