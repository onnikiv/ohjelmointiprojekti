### Task 1   
a) Saapumistapahtuma luo uuden saapumistapahtuman, koska järjestelmän jatkuvuus vaatii uusien saapumisten simulointia. Tämä mallintaa esimerkiksi asiakkaiden tai tehtävien jatkuvaa virtaa järjestelmässä.

b) Palvelun alkaminen luo poistumistapahtuman, joka merkitsee palvelun päättymistä ja resurssien vapautumista seuraaville yksiköille.

### Task 4


# Three-Phase Simulation Example: Call Centre

## Initial Setup: Clock 0
The simulation begins with the following setup:

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
| Work Complete | X | Y |
|---------------|---|---|
|               | 0 | 0 |

---

## Clock 5: Event B1
1. **A-Phase**: Advance the clock to 5 minutes, process event B1.
2. **B-Phase**: 
   - Customer X1 arrives at the router queue.
   - Schedule the next arrival of X at time 10 (B1).
3. **C-Phase**:
   - X1 is routed to the router, scheduled to complete at time 6 (B3).

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
| Work Complete | X | Y |
|---------------|---|---|
|               | 0 | 0 |

---

## Clock 6: Event B3
1. **A-Phase**: Advance the clock to 6 minutes, process event B3.
2. **B-Phase**: 
   - X1 is transferred to Operator 1's queue.
3. **C-Phase**:
   - Operator 1 begins processing X1, scheduled to complete at time 10 (B4).

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
| Work Complete | X | Y |
|---------------|---|---|
|               | 0 | 0 |

---

## Clock 10: Events B2, B1, B4
1. **A-Phase**: Advance the clock to 10 minutes.
2. **B-Phase**: 
   - **B2**: Customer Y1 arrives at the router queue.
   - **B1**: Customer X2 arrives at the router queue after Y1.
   - **B4**: Operator 1 completes X1's processing. Increment work completed for X.
   - Schedule:
     - Next X arrival (B1) at 15 minutes.
     - Next Y arrival (B2) at 20 minutes.
3. **C-Phase**:
   - Router processes Y1 first (FIFO), scheduled to complete routing at time 11 (B3).

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
| Work Complete | X | Y |
|---------------|---|---|
|               | 1 | 0 |

---

## Clock 11: Event B3
1. **A-Phase**: Advance the clock to 11 minutes, process event B3.
2. **B-Phase**: 
   - Y1 is transferred to Operator 2's queue.
3. **C-Phase**:
   - Operator 2 begins processing Y1, scheduled to complete at time 18 (B5).

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
| Work Complete | X | Y |
|---------------|---|---|
|               | 1 | 0 |

---

## Clock 18: Event B5
1. **A-Phase**: Advance the clock to 18 minutes, process event B5.
2. **B-Phase**: 
   - Y1 finishes processing in Operator 2. Increment work completed for Y.
3. **C-Phase**:
   - No additional events.

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
| Work Complete | X | Y |
|---------------|---|---|
|               | 1 | 1 |

---

## Conclusion
The simulation ends when one client of type Y (Y1) exits the system at Clock 18. The updated event list, state table, and results reflect this milestone.

---


