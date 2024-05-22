/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package _generated_sources_swagger;

import br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.AdminRequestDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.ClienteRequestDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.MimoRequestDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.PagamentoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-22T00:21:45.152441700-03:00[America/Sao_Paulo]")
@Validated
@Tag(name = "follow-up", description = "Acompanhar status do pedido")
public interface NeighborfoodApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /neighborfood/acompanhamento/{idPedido} : Procura o status de um pedido
     * Retorna o status de um pedido
     *
     * @param idPedido id do pedido (required)
     * @return successful operation (status code 200)
     *         or Id inválido (status code 400)
     *         or Pedido não encontrado (status code 404)
     */
    @Operation(
        operationId = "findOrderByIdOrder",
        summary = "Procura o status de um pedido",
        description = "Retorna o status de um pedido",
        tags = { "follow-up" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/acompanhamento/{idPedido}",
        produces = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponseDTO> findOrderByIdOrder(
        @Parameter(name = "idPedido", description = "id do pedido", required = true, in = ParameterIn.PATH) @PathVariable("idPedido") Long idPedido
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"total\" : 5.637376656633329, \"pedido\" : { \"idCliente\" : 6, \"id\" : 0, \"Produtos\" : [ { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" }, { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /neighborfood/painel/pedido/lista/{idAdmin} : Lista de pedidos efetuados contendo seus clientes, itens, status, valores e data de pedido e data de entrega.
     * Lista os pedidos recebidos
     *
     * @param idAdmin id identificador do administrador (required)
     * @return Lista de pedidos (status code 200)
     *         or Id inválido (status code 400)
     *         or Mimo não disponível (status code 404)
     */
    @Operation(
        operationId = "listOrders",
        summary = "Lista de pedidos efetuados contendo seus clientes, itens, status, valores e data de pedido e data de entrega.",
        description = "Lista os pedidos recebidos",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AcompanhamentoResponseDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Mimo não disponível")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/painel/pedido/lista/{idAdmin}",
        produces = { "application/json" }
    )
    default ResponseEntity<List<AcompanhamentoResponseDTO>> listOrders(
        @Parameter(name = "idAdmin", description = "id identificador do administrador", required = true, in = ParameterIn.PATH) @PathVariable("idAdmin") Long idAdmin
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"total\" : 5.637376656633329, \"pedido\" : { \"idCliente\" : 6, \"id\" : 0, \"Produtos\" : [ { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" }, { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" } ] } }, { \"total\" : 5.637376656633329, \"pedido\" : { \"idCliente\" : 6, \"id\" : 0, \"Produtos\" : [ { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" }, { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" } ] } } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/login : Se cadastrar, logar
     * Identificação do cliente
     *
     * @param clienteRequestDTO Identifica um cliente logado (optional)
     * @return Usuário logado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "login",
        summary = "Se cadastrar, logar",
        description = "Identificação do cliente",
        tags = { "login" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário logado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> login(
        @Parameter(name = "ClienteRequestDTO", description = "Identifica um cliente logado") @Valid @RequestBody(required = false) ClienteRequestDTO clienteRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/painel/login : Cadastrar adm, logar adm
     * Identificação do adm
     *
     * @param adminRequestDTO Identifica um adminsitrador logado (optional)
     * @return Usuário logado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "loginAdm",
        summary = "Cadastrar adm, logar adm",
        description = "Identificação do adm",
        tags = { "loginAdm" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário logado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/painel/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> loginAdm(
        @Parameter(name = "AdminRequestDTO", description = "Identifica um adminsitrador logado") @Valid @RequestBody(required = false) AdminRequestDTO adminRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /neighborfood/menu : Apresenta o menu com itens opcionais
     * menu de opções
     *
     * @return Apresenta os itens de menu (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "menu",
        summary = "Apresenta o menu com itens opcionais",
        description = "menu de opções",
        tags = { "menu" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Apresenta os itens de menu", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/menu",
        produces = { "application/json" }
    )
    default ResponseEntity<Object> menu(
        
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/pedido : Realizar um pedido
     * Fazer um  pedido
     *
     * @param pedidoRequestDTO Cria um novo pedido (optional)
     * @return Pedido criado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "order",
        summary = "Realizar um pedido",
        description = "Fazer um  pedido",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido criado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/pedido",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponseDTO> order(
        @Parameter(name = "PedidoRequestDTO", description = "Cria um novo pedido") @Valid @RequestBody(required = false) PedidoRequestDTO pedidoRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"total\" : 5.637376656633329, \"pedido\" : { \"idCliente\" : 6, \"id\" : 0, \"Produtos\" : [ { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" }, { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/pagamento : Realiza o pagamento do pedido
     * Realiza pagamento
     *
     * @param pagamentoDTO  (required)
     * @return pagamento realizado com sucesso. (status code 200)
     *         or Id inválido (status code 400)
     *         or Pedido não encontrado (status code 404)
     */
    @Operation(
        operationId = "payment",
        summary = "Realiza o pagamento do pedido",
        description = "Realiza pagamento",
        tags = { "payment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "pagamento realizado com sucesso.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/pagamento",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponseDTO> payment(
        @Parameter(name = "PagamentoDTO", description = "", required = true) @Valid @RequestBody PagamentoDTO pagamentoDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"total\" : 5.637376656633329, \"pedido\" : { \"idCliente\" : 6, \"id\" : 0, \"Produtos\" : [ { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" }, { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param clienteRequestDTO Cria um novo cliente (optional)
     * @return Usuário logado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "register",
        summary = "Se cadastrar, logar",
        description = "Cria cliente",
        tags = { "register" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário logado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/cadastro",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> register(
        @Parameter(name = "ClienteRequestDTO", description = "Cria um novo cliente") @Valid @RequestBody(required = false) ClienteRequestDTO clienteRequestDTO
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/painel/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param adminRequestDTO Cria um novo administrador (optional)
     * @return Usuário cadastrao (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "registerAdm",
        summary = "Se cadastrar, logar",
        description = "Cria cliente",
        tags = { "registerAdm" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário cadastrao", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/painel/cadastro",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> registerAdm(
        @Parameter(name = "AdminRequestDTO", description = "Cria um novo administrador") @Valid @RequestBody(required = false) AdminRequestDTO adminRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /neighborfood/painel/produto/cadastro/{idAdmin} : Cadastra produtos
     * Cadastra produtos em lote
     *
     * @param idAdmin id identificador do administrador (required)
     * @return Produtos cadastrados (status code 200)
     *         or Id inválido (status code 400)
     *         or Produto inválido (status code 404)
     */
    @Operation(
        operationId = "registerProduct",
        summary = "Cadastra produtos",
        description = "Cadastra produtos em lote",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Produtos cadastrados", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Produto inválido")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/painel/produto/cadastro/{idAdmin}",
        produces = { "application/json" }
    )
    default ResponseEntity<Object> registerProduct(
        @Parameter(name = "idAdmin", description = "id identificador do administrador", required = true, in = ParameterIn.PATH) @PathVariable("idAdmin") Long idAdmin
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/painel/cliente : Envia mimo ao último cliente que realizou um pedido
     * Envia mimo ao cliente
     *
     * @param mimoRequestDTO  (required)
     * @return Mimo enviado (status code 200)
     *         or Id inválido (status code 400)
     *         or Mimo não disponível (status code 404)
     */
    @Operation(
        operationId = "sendBonus",
        summary = "Envia mimo ao último cliente que realizou um pedido",
        description = "Envia mimo ao cliente",
        tags = { "customers" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Mimo enviado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MimoDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Mimo não disponível")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/painel/cliente",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<MimoDTO> sendBonus(
        @Parameter(name = "MimoRequestDTO", description = "", required = true) @Valid @RequestBody MimoRequestDTO mimoRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"codigo\" : \"codigo\", \"desconto\" : 0.8008281904610115, \"idCliente\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /neighborfood/pedido/update : Atualizar um pedido
     * Atualizar itens de um pedido já realizado
     *
     * @param pedidoRequestDTO atualiar um  pedido (optional)
     * @return Pedido atualizado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "updateOrder",
        summary = "Atualizar um pedido",
        description = "Atualizar itens de um pedido já realizado",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/neighborfood/pedido/update",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponseDTO> updateOrder(
        @Parameter(name = "PedidoRequestDTO", description = "atualiar um  pedido") @Valid @RequestBody(required = false) PedidoRequestDTO pedidoRequestDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"total\" : 5.637376656633329, \"pedido\" : { \"idCliente\" : 6, \"id\" : 0, \"Produtos\" : [ { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" }, { \"preco\" : 5.962133916683182, \"img\" : \"img\", \"nome\" : \"nome\", \"id\" : 1, \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
