const uploadDates=()=>{
    var x=document.getElementById("idopont")
                  
                      for (let i = 11; i < 21; i++) {
                        x.add(new Option(i+":00"));
                        x.add(new Option(i+":15"));
                        x.add(new Option(i+":30"));
                        x.add(new Option(i+":45"));
                      }
                    
}
uploadDates()
