package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin;

%%

    unicode_input_character = [\u0000-\uffff]
    ht  = \u0009
    lf  = \u000a
    ff  = \u000c
    cr  = \u000d
    sp  = " "

    line_terminator = {lf} | {cr} | {cr} {lf}

    input_character = !(!{unicode_input_character} | ({cr} | {lf}))

    escape_character = "\"

    not_star =  !(!{input_character} | "*") | {line_terminator}
    not_star_not_slash = !(!{input_character} | ("*" | "/")) | {line_terminator}
    not_star_not_rbracket = !(!{input_character} | ("*" | ")")) | {line_terminator}

  ascii_char = [\u0000-\u00ff]

  symbols = [\u0020-\u002F] | [\u003A-\u0040] | \u005B | [\u005D-\u005E] | \u0060 | [\u007B-\u007E]
   //- '+' - '.' - '(' - ')' - '[' - ']' - '{' - '}'
  unicode_input_character_minus_symbols = !(!{unicode_input_character} | {symbols})

  digit = [0-9]

  identifier_first_character = !(!{unicode_input_character_minus_symbols} | {cr} {lf} | {digit})
  identifier_following_character = !(!{unicode_input_character_minus_symbols} | {cr} {lf})

  // un-printable characters
//  tab = 9
//  cr = 13
//  lf = 10
//  blank = " "

  single_quote = "'"

  quote = "\""

  underscore = "_"
  plus = "+"
  minus = "-"
  mult = "*"
  div = "/"
  assignop = ":="

  exclamation = "!"

  // relational symbols
  equals = "="
  not_equals = "!="
  same_helper = "=="
  not_same_helper = "!=="
  xxx = "!=="
  lab = "<"
  lab_equals = "<="
  rab = ">"
  rab_equals = ">="

  // separator symbols
  comma = ","
  colon = ":"
  semicolon = ";"
  namespace_separator = "::"
  hash = "#"
  l_paren = "("
  r_paren = ")"
  l_bracket = "["
  r_bracket = "]"
  l_curly_bracket = "{"
  r_curly_bracket = "}"
  right_arrow = "->"
  left_arrow = "<-"
  l_guillemot = "«"
  r_guillemot = "»"

  // reserved words
  abstract = "abstract"
  access = "access"
  actor = "actor"
  aggregation = "aggregation"
  alias = "alias"
  allow = "allow"
  all = "all"
  and = "and"
  any = "any"
  anyone = "anyone"
  apply = "apply"
  association = "association"
  as = "as"
  attribute = "attribute"
  begin = "begin"
  broadcast = "broadcast"
  by = "by"
  call = "call"
  catch = "catch"
  clazz = "class"
  component = "component"
  composition = "composition"
  connector = "connector"
  constructor = "constructor"
  create = "create"
  datatype = "datatype"
  delete = "delete"
  dependency = "dependency"
  derived = "derived"
  destroy = "destroy"
  do = "do"
  else = "else"
  elseif = "elseif"
  end = "end"
  entry = "entry"
  enumeration = "enumeration"
  exit = "exit"
  extends = "extends"
  extent = "extent"
  external = "external"
  false = "false"
  final = "final"
  finally = "finally"
  function = "function"
  id = "id"
  if =  "if"
  implements = "implements"
  import = "import"
  in = "in"
  initial = "initial"
  inout = "inout"
  interface = "interface"
  invariant = "invariant"
  is = "is"
  link = "link"
  enumeration_literal = "literal"
  load = "load"
  model = "model"
  navigable = "navigable"
  new = "new"
  none = "none"
  nonunique = "nonunique"
  not = "not" | exclamation
  null = "null"
  on = "on"
  operation = "operation"
  opposite = "opposite"
  or = "or"
  ordered = "ordered"
  out = "out"
  package = "package"
  parameterset = "parameterset"
  port = "port"
  postcondition = "postcondition"
  precondition = "precondition"
  primitive = "primitive"
  private = "private"
  profile = "profile"
  property = "property"
  protected = "protected"
  provided = "provided"
  public = "public"
  query = "query"
  raise = "raise"
  raises = "raises"
  read = "read"
  readonly = "readonly"
  reception = "reception"
  reference = "reference"
  repeat = "repeat"
  required = "required"
  return = "return"
  role = "role"
  self = "self"
  send = "send"
  signal = "signal"
  specializes = "specializes"
  state = "state"
  statemachine = "statemachine"
  static = "static"
  stereotype = "stereotype"
  subsets = "subsets"
  terminate = "terminate"
  then = "then"
  to = "to"
  transition = "transition"
  true = "true"
  try = "try"
  type = "type"
  unique = "unique"
  unlink = "unlink"
  unordered = "unordered"
  until = "until"
  update = "update"
  var = "var"
  when = "when"
  where = "where"
  while = "while"

  // arithmetic symbols
  plus = "+"
  minus = "-"
  mult = "*"
  div = "/"
  assignop = ":="

  // relational symbols
  equals = "="
  equals_equals = "=="
  not_equals_equals = "!=="
  lab = "<"
  lab_equals = "<="
  rab = ">"
  rab_equals = ">="
  not_equals = "!="

  elvis = "?:"

  question = "?"

  bangs = "!!"

  // separator symbols
  comma = ","
  colon = ":"
  semicolon = ";"
  dot = "."
  optional_dot = "?."
  namespace_separator = "::"
  hash = "#"
  l_paren = "("
  r_paren = ")"
  l_bracket = "["
  r_bracket = "]"
  l_curly_bracket = "{"
  r_curly_bracket = "}"
  right_arrow = "->"
  left_arrow = "<-"
  l_guillemot = "«"
  r_guillemot = "»"

%%

[^]                                             {                         return BAD_CHARACTER; }
