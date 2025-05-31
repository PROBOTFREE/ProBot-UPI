@extends("layouts.app")

		@section("wrapper")
            <div class="page-wrapper">
                <div class="page-content">
                    <!--breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Applications</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0">
                                    <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">To Do List</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="ms-auto">
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary">Settings</button>
                                <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
                                    <a class="dropdown-item" href="javascript:;">Another action</a>
                                    <a class="dropdown-item" href="javascript:;">Something else here</a>
                                    <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end breadcrumb-->
                    <div class="card">
                        <div class="card-body">
                            <h4 class="mb-0">To Do List</h4>
                            <hr/>
                            <div class="row gy-3">
                                <div class="col-md-10">
                                    <input id="todo-input" type="text" class="form-control" value="">
                                </div>
                                <div class="col-md-2 text-end d-grid">
                                    <button type="button" onclick="CreateTodo();" class="btn btn-primary">Add todo</button>
                                </div>
                            </div>
                            <div class="form-row mt-3">
                                <div class="col-12">
                                    <div id="todo-container"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		@endsection

@section("script")
<script>
	// to do list
	 var todos = [{
		text: "take out the trash",
		done: false,
		id: 0
	}];
	var currentTodo = {
		text: "",
		done: false,
		id: 0
	}
	document.getElementById("todo-input").oninput = function (e) {
		currentTodo.text = e.target.value;
	};
	/*
		//jQuery Version
		$('#todo-input').on('input',function(e){
			currentTodo.text = e.target.value;
		   });
		*/
	function DrawTodo(todo) {
		var newTodoHTML = `
		<div class="pb-3 todo-item" todo-id="${todo.id}">
			<div class="input-group">

					<div class="input-group-text">
						<input type="checkbox" onchange="TodoChecked(${todo.id})" aria-label="Checkbox for following text input" ${todo.done&& "checked"}>
					</div>

				<input type="text" readonly class="form-control ${todo.done&&" todo-done "} " aria-label="Text input with checkbox" value="${todo.text}">

					<button todo-id="${todo.id}" class="btn btn-outline-secondary bg-danger text-white" type="button" onclick="DeleteTodo(this);" id="button-addon2 ">X</button>

			</div>
		</div>
		  `;
		var dummy = document.createElement("DIV");
		dummy.innerHTML = newTodoHTML;
		document.getElementById("todo-container").appendChild(dummy.children[0]);
		/*
			//jQuery version
			 var newTodo = $.parseHTML(newTodoHTML);
			 $("#todo-container").append(newTodo);
			*/
	}

	function RenderAllTodos() {
		var container = document.getElementById("todo-container");
		while (container.firstChild) {
			container.removeChild(container.firstChild);
		}
		/*
			//jQuery version
			  $("todo-container").empty();
			*/
		for (var i = 0; i < todos.length; i++) {
			DrawTodo(todos[i]);
		}
	}
	RenderAllTodos();

	function DeleteTodo(button) {
		var deleteID = parseInt(button.getAttribute("todo-id"));
		/*
			//jQuery version
			  var deleteID = parseInt($(button).attr("todo-id"));
			*/
		for (let i = 0; i < todos.length; i++) {
			if (todos[i].id === deleteID) {
				todos.splice(i, 1);
				RenderAllTodos();
				break;
			}
		}
	}

	function TodoChecked(id) {
		todos[id].done = !todos[id].done;
		RenderAllTodos();
	}

	function CreateTodo() {
		newtodo = {
			text: currentTodo.text,
			done: false,
			id: todos.length
		}
		todos.push(newtodo);
		RenderAllTodos();
	}
</script>
@endsection
