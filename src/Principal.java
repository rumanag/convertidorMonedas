import com.alura.bases.JsonFile;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Principal {

    public static void main(String[] args) {

        List<JsonFile> jsonFileArray = new ArrayList<>();
        String direccion = "https://v6.exchangerate-api.com/v6/f150c23d7e0fe9caa318d007/latest/USD";

        HttpResponse<String> response;
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
        System.out.println("_________________________________________________________________");
        System.out.println("ESTE ES EL JASON RAW FROM SOURCE" + response.body());
        System.out.println("_________________________________________________________________");
        */

        String json = response.body();  // json tiene dos niveles de objetos y  primitivas
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        /*
        System.out.println("APLICANDO GSON CON MAP EN  userMap: " + gson.fromJson(json, TreeMap.class).get("conversion_rates"));
        System.out.println("_________________________________________________________________");
        */

        Map<?, ?> userMap = gson.fromJson(json, TreeMap.class);
        Scanner leaConsola = new Scanner(System.in);

        int miSalida =0;
        do {

            // Los códigos mencionados en el mensaje a consola pueden estar en un campo desplegable en HTML
            System.out.println("\n*****************************************************************");
            System.out.println("- Escriba el código de la moneda a convertir: ARS=Peso Argentino, BRL= Real Brasil, COP= PESO COLOMBIANO..Etc.\n" +
                    "                                              Ver lista de códigos en la documentación (README.MD)\n" +
                    "- Para terminar, digite 'SALIR' ");

            try {

                var  codigoPais = leaConsola.nextLine().toUpperCase();
                double tasaDeCambio = (double) ((Map<?, ?>) (userMap.get("conversion_rates"))).get(codigoPais);


                System.out.println("_________________________________________________________________");
                System.out.println("Codigo de pais: " + codigoPais +
                        " Tasa de cambio frente al dolar " + tasaDeCambio);
                System.out.println("_________________________________________________________________");

               /*
                System.out.println("Codigo de pais: "+ codigoPais + " - tasa de cambio frente al dolar: " +
                                   ((Map<?, ?>) (userMap.get("conversion_rates"))).get(codigoPais));
                */

                System.out.println("Por favor, escriba el tipo de conversion con un espacio  y el valor a convertir: Ej: 1 2500 \n" +
                        "1 de USD a "+codigoPais + " valor a convertir\n" +
                        "2.de " +codigoPais +" a USD  valor a convertir\n");

                String tipoValorConversion = leaConsola.nextLine();



                /*
                System.out.println("_________________________________________________________________");
                System.out.println("TIPO DE CONVERSION  Y VALOR  " + tipoValorConversion);
                System.out.println("_________________________________________________________________");
                */

                int sizeOfTipoValorConversion = tipoValorConversion.length();

                /*
                System.out.println("TAMAÑO DE tipoValorConversion : " + sizeOfTipoValorConversion);
                System.out.println("_________________________________________________________________");
                */

                int tipoConversion = Integer.parseUnsignedInt(tipoValorConversion.substring(0,1));
                double valorConversion =  Double.parseDouble(tipoValorConversion
                        .substring(2,sizeOfTipoValorConversion));

                /*
                System.out.println("TIPO DE CONVERSION: " +tipoConversion);
                System.out.println("_________________________________________________________________");
                System.out.println(" VALOR A CONVERTIR: "+ valorConversion);
                System.out.println("_________________________________________________________________");
                */

                double valorConvertido = 0;
                JsonFile miJsonfile =  new JsonFile();

                switch (tipoConversion){

                    case 1:
                        System.out.println("*****************************************************************");
                        valorConvertido = tasaDeCambio * valorConversion;
                        System.out.println(valorConversion + " USD - equivale a "+valorConvertido +" "+ codigoPais );
                        miJsonfile.setDeMoneda("USD");
                        miJsonfile.setAMoneda(codigoPais);
                        break;

                    case 2:
                        System.out.println("*****************************************************************");
                        valorConvertido = valorConversion/tasaDeCambio;
                        System.out.println(valorConversion + " " +codigoPais + " equivale a  " + valorConvertido + " USD");
                        miJsonfile.setDeMoneda(codigoPais);
                        miJsonfile.setAMoneda("USD");
                        break;

                    default:
                        System.out.println("el tipo de conversión es incorrecto. Intente de nuevo");
                }

                miJsonfile.setValorConvertido(valorConvertido);
                miJsonfile.setTasaDeCambioBase(tasaDeCambio);


//                System.out.println("CON MIJASONFILE VOY A CARGAR EL ARREGLO: "+ miJsonfile);

                jsonFileArray.add(miJsonfile);

//                 System.out.println( "ESTE ES EL ARREGLO :" + jsonFileArray);



            } catch (NullPointerException e){
                System.out.println("_________________________________________________________________");
                miSalida = 1;
            } catch (NumberFormatException e){
                System.out.println("_________________________________________________________________");
                System.out.println("No se digitó el tipo de conversión. Por favor intente de nuevo");
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("_________________________________________________________________");
                System.out.println("no se digitó el valor a convertir. Por favor intente de nuevo");
            }

        } while (miSalida == 0);

        try {
            FileWriter escritura= new FileWriter("trazaMonedas.json");
            escritura.write(gson.toJson(jsonFileArray));
            escritura.close();

            System.out.println("Para estadísticas y trazabilidad, se generó  el archivo trazaMonedas.json +\n" +
                                "Por favor realizar backup porque se sobreescribirá en la siguiene sesión. ");

        } catch (IOException e) {
            System.out.println("ESTÁ PASANDO POR UNA EXCEPCION");
            //throw new RuntimeException(e);
        }
        System.out.println("Fin de Proceso. Gracias.");
    }
}