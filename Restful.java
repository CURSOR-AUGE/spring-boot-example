@RestController
@RequestMapping("/crud")
public class CRUDController {
     
    @GetMapping
    public List<CrudInput> read(@RequestBody CrudInput crudInput) {
        List<CrudInput> returnList = new ArrayList<CrudInput>();
        returnList.add(crudInput);
        return returnList;
    }
     
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public HttpHeaders save(@RequestBody CrudInput crudInput) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
          linkTo(CRUDController.class).slash(crudInput.getTitle()).toUri());
        return httpHeaders;
    }
     
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) { }
}
