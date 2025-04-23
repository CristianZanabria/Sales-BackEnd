package com.zdevs.textBlock;

public class Program {

    public void m1Simple() {
        String sql = """
                Este bloque  de tecxto que no requiere un  opreador
                """;
        System.out.println(sql);
    }

    public void m2Indentation() {
        String Page = """
                <html>
                     <body>
                        <span> example text </spam>
                      </body>
                 </html>""";

        String json = """
                {
                "name": "cris",
                "age" : 39;
                "status" : true
                }
                """;
        System.out.println(Page);
        System.out.println(json);
    }

    public void m3ScapeDoubleQuotes() {
        String text = """
                Jehova es mi pastor y nada me faltara \"
                y el estara en todo momento en vida 
                """;
        System.out.println(text);
    }
    public void m6Indentation() {
        String page = """
                <html>
                     <body>
                        <span> example %s </spam>
                      </body>
                 </html>""" .formatted("zdevs");
        System.out.println(page);
    }

    public void m4TextStringVariable(String name, String age, String status) {
        String json = """
                {
                "name": $name,
                "age" : Sage;
                "status" : $status
                }
                """.replace("$name", name)
                .replace("$age", age)
                .replace("$status", status);

        System.out.println(json);
    }

    public static void main(String[] args) {
        Program app = new Program();
        app.m6Indentation();


    }
}
